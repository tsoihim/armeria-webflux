package io.github.tsoihim;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("device")
@AllArgsConstructor
@Getter
public class Device {

    @Id
    private Long id;

    private String name;

}
