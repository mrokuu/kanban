package org.example.valueobjects;

import lombok.*;

import java.io.Serializable;
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class StartedTasks implements Serializable {

    private final Double value;

}
