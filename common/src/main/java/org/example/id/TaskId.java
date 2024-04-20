package org.example.id;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class TaskId implements Serializable {

    private final UUID value;
}
