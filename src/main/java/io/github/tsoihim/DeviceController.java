package io.github.tsoihim;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping("/devices")
    Flux<DeviceDTO> getDevices() {
        return deviceService.fetchDevices();
    }

    @GetMapping("/devices/{deviceId}")
    Mono<DeviceDTO> getDevices(@PathVariable Long deviceId) {
        return deviceService.fetchDevice(deviceId);
    }

}