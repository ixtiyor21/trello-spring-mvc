package uz.ixtiyor21.trello_magic.enums.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 06.03.2022 8:55
 * Project : Trello_magic
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum OrgStatus{
    NOT_ACTIVE("NOT_ACTIVE"),
    ACTIVE("ACTIVE"),
    BLOCKED("BLOCKED");
    private String code;
}
