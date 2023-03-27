package example;

import crud.*;
import hibernate.HibernateUtil;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) throws SQLException {
       new DatabaseInitService().initDb();//create DB and fill it*/
        /*Client client = new Client();
        client.setName("Unknown");

        Planet planet=new Planet();
        planet.setId("MARS56");
        planet.setName("Vairus");

        new PlanetService().create(planet);
        new PlanetService().getById("SATURN258");
        new PlanetService().delete("SATURN258");
        System.out.println( new PlanetService().getAll().toString());

        new ClientService().create(client);
        new ClientService().delete(11);
        System.out.println(new ClientService().getById(12));
        System.out.println(new ClientService().getAll().toString());

*/
       final SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Ticket ticket=new Ticket(LocalDateTime.parse("2022-03-17T12:30:00"),  new ClientService().getById(4), new PlanetService().getById("SATURN258"), new PlanetService().getById("MOON51"));
        new TicketService(factory).create(ticket);
       ticket.setFromPlanet(new PlanetService().getById("MARS82"));
        new TicketService(factory).update(ticket);
        new TicketService(factory).delete(10l);
        System.out.println(new TicketService(factory).getAll().toString());
    }
}