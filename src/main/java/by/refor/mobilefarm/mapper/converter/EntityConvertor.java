package by.refor.mobilefarm.mapper.converter;

public interface EntityConvertor<E,D> {
    D fromEntityToDto(E entity);
    E fromDtoToEntity(D dto);

    E fillEntityByDto(D dto, E entity);
}
