package pl.patryklubik.microserviceREST.data;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Patryk Łubik on 08.04.2021.
 */

@Service
public class DataService {

    private final DataRepository repository;

    DataService(DataRepository repository) {
        this.repository = repository;
    }

    String findById(Integer id) {

        return repository
                .getOne(id)
                .getContent();
    }

    List<Data> getAllData() {
        return new ArrayList<>(repository
                .findAll());
    }

    Data save(Data data) {

        return repository.save(data);
    }

    Data updateData(Integer id, String newContent) {

        Data updatedData = new Data();

            var data = repository.findById(id);
            data.ifPresent(t -> {
                t.setContent(newContent);
                repository.save(t);

                updatedData.setId(id);
                updatedData.setContent(newContent);
            });

        return updatedData;
    }

    void deleteData(Integer id) {

        var data = repository.findById(id);

        data.ifPresent(repository::delete);
    }
}
