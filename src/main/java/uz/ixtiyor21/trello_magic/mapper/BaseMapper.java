package uz.ixtiyor21.trello_magic.mapper;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:56
 * Project : Trello_magic
 */
public interface BaseMapper <E,D,CD,UD> extends Mapper{

    D toDto(E e);

    List<D> toDto(List<E> e);

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD ud);


}
