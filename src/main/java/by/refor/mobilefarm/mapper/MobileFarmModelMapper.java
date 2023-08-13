package by.refor.mobilefarm.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MobileFarmModelMapper extends ModelMapper {
    public <S,D> List<D> mapList(List<S> sources, Class<D> destination){
        List<D> destinationList = new ArrayList<>();
        sources.forEach(source -> destinationList.add(super.map(source, destination)));
        return destinationList;
    }
}
