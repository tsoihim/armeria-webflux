package io.github.tsoihim;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Flux<DeviceDTO> fetchDevices() {
        return deviceRepository.findAll()
                .map(v -> objectMapper.convertValue(v, DeviceDTO.class));
    }

    public Mono<DeviceDTO> fetchDevice(Long id) {
        return deviceRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(v -> objectMapper.convertValue(v, DeviceDTO.class));
    }

}
