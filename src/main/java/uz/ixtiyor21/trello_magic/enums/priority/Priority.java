package uz.ixtiyor21.trello_magic.enums.priority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 06.03.2022 8:50
 * Project : Trello_magic
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Priority {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH");
    private String code;
}
