package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarNameCatalog {
    private List<Name> names;

    public CarNameCatalog(List<Name> carNames) {
        validate(carNames);
        this.names = carNames;
    }

    private void validate(List<Name> names){
        Integer size=names.size();

        Set<String> nonDuplicate = names
                .stream()
                .map(Name::getValue)
                .collect(Collectors.toSet());

        Integer nonDuplicateSize= nonDuplicate.size();

        if(size!=nonDuplicateSize){
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public List<Name> getNames() {
        return names;
    }
}