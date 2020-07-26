package yh.sqli.hackton.seats_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yh.sqli.hackton.seats_reservation.domain.Floor;
import yh.sqli.hackton.seats_reservation.domain.Zone;
import yh.sqli.hackton.seats_reservation.payloud.response.FloorResponse;
import yh.sqli.hackton.seats_reservation.payloud.response.ZoneResponse;
import yh.sqli.hackton.seats_reservation.repository.FloorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static yh.sqli.hackton.seats_reservation.constant.Constants.API_BASE_URL;

@RestController
@RequestMapping(API_BASE_URL + "/floor")
public class FloorController {
    @Autowired
    private FloorRepository floorRepository;

    @GetMapping("/all")
    public ResponseEntity<List<FloorResponse>> all() {
        final List<FloorResponse> floorResponses = floorRepository.findAll().stream()
                .map(floor -> {
                    return FloorResponse.of(floor);
                }).collect(Collectors.toList());

        return ResponseEntity.ok(floorResponses);
    }

    @GetMapping("/allZonesByFloorId/{id}")
    public ResponseEntity<List<ZoneResponse>> findAllZonesByFloorId(@PathVariable("id") Integer id) {
        List<Zone> zones = new ArrayList<>();
        final Optional<Floor> floor = floorRepository.findById(id);
        if (floor.isPresent()) {
            zones = floor.get().getZones();
        }
        final List<ZoneResponse> zoneResponseList = zones.stream().map(zone -> {
            return ZoneResponse.of(zone);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(zoneResponseList);
    }

}
