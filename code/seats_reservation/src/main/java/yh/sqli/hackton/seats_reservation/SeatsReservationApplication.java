package yh.sqli.hackton.seats_reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import yh.sqli.hackton.seats_reservation.domain.*;
import yh.sqli.hackton.seats_reservation.exception.AppException;
import yh.sqli.hackton.seats_reservation.repository.*;
import yh.sqli.hackton.seats_reservation.services.WorkTableService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SeatsReservationApplication implements CommandLineRunner {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private WorkTableService workTableService;

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private FloorRepository floorRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(SeatsReservationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Seat> table1Seats = Stream.of(
                new Seat("Seat001", true, false),
                new Seat("Seat002", true, false),
                new Seat("Seat003", false, true),
                new Seat("Seat004", false, true)
        ).collect(Collectors.toList());


        seatRepository.saveAll(table1Seats);

/*        table1Seats.forEach(seat -> {
            seatRepository.save(seat);
        });*/

        List<Seat> table2Seats = Stream.of(
                new Seat("Seat005", true, false),
                new Seat("Seat006", true, false),
                new Seat("Seat007", true, false),
                new Seat("Seat008", false, true),
                new Seat("Seat009", false, true),
                new Seat("Seat010", false, true)
        ).collect(Collectors.toList());

        seatRepository.saveAll(table2Seats);

        WorkTable workTable1 = new WorkTable("Table001");
        workTable1.setSeats(table1Seats);

        WorkTable workTable2 = new WorkTable("Table002");
        workTable2.setSeats(table2Seats);

        workTableService.save(workTable1);
        workTableService.save(workTable2);

        List<WorkTable> workTables = Stream.of(workTable1, workTable2).collect(Collectors.toList());

        Zone zone1 = new Zone("Zone-002");
        zone1.setWorkTables(workTables);
        zoneRepository.save(zone1);

        Floor floor = new Floor("Floor 1");
        floor.setZones(Collections.singletonList(zone1));
        floorRepository.save(floor);

        Role role_user = new Role(RoleName.ROLE_USER);
        roleRepository.save(role_user);

        Role role_admin = new Role(RoleName.ROLE_ADMIN);
        roleRepository.save(role_admin);

        User user = User.of("yyounes", "yyounes@seat.ma", "seat");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User role not set."));
        user.setRoles(Collections.singleton(userRole));

        userRepository.save(user);

    }
}
