package yh.sqli.hackton.seats_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yh.sqli.hackton.seats_reservation.domain.WorkTable;
import yh.sqli.hackton.seats_reservation.domain.Zone;
import yh.sqli.hackton.seats_reservation.payloud.response.WorkTableResponse;
import yh.sqli.hackton.seats_reservation.payloud.response.ZoneResponse;
import yh.sqli.hackton.seats_reservation.repository.ZoneRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static yh.sqli.hackton.seats_reservation.constant.Constants.API_BASE_URL;

@RestController
@RequestMapping(API_BASE_URL + "/zone")
public class ZoneControlller {

    @Autowired
    private ZoneRepository zoneRepository;

    @GetMapping("/all")
    public ResponseEntity<List<ZoneResponse>> findAll() {
        final List<ZoneResponse> zoneResponses = zoneRepository.findAll().stream().map(zone -> {
            return ZoneResponse.of(zone);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(zoneResponses);
    }

    @GetMapping("/workTablesByZoneId/{id}")
    public ResponseEntity<List<WorkTableResponse>> findWorkTablesByZoneId(@PathVariable("id") Integer id) {
        List<WorkTable> workTables = new ArrayList<>();
        final Zone zone = zoneRepository.getOne(id);
        if (zone != null) {
            workTables = zone.getWorkTables();
        }
        final List<WorkTableResponse> workTableResponse = workTables.stream().map(workTable -> {
            return WorkTableResponse.of(workTable);
        })
                .collect(Collectors.toList());
        return ResponseEntity.ok(workTableResponse);
    }


}
