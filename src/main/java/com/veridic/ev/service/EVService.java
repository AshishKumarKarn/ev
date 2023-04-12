package com.veridic.ev.service;

import com.veridic.ev.pojo.Station;
import com.veridic.ev.repository.EVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service")
public class EVService {
    @Autowired
    private EVRepository repository;

    public Iterable<Station> getALlStations(Integer size, String sort, String field) {

        PageRequest pageable = PageRequest.ofSize(10);
        if (size != null) {
            pageable = PageRequest.ofSize(size);
        }
        if (sort != null) {
            if (sort.equals("asc")) {
                pageable = pageable.withSort(Sort.by(Sort.Direction.ASC, field));
            } else if (sort.equals("desc")) {
                pageable = pageable.withSort(Sort.by(Sort.Direction.DESC, field));
            }
        }
        return repository.findAll(pageable);
    }

    public Long save(Station station) {
        Station save = repository.save(station);
        return save.getStationId();
    }

    public int updateById(Long id, Station station) {
        return repository.updateByField(station.getStationName(), station.getStationImage()
                , station.getStationId(), station.getStationAddress(), station.getStationPricing(), List.of(id));
    }

    public Optional<Station> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
