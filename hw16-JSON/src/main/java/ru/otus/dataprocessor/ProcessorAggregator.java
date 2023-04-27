package ru.otus.dataprocessor;

import ru.otus.model.Measurement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessorAggregator implements Processor {

    @Override
    public Map<String, Double> process(List<Measurement> data) {
        //группирует выходящий список по name, при этом суммирует поля value
//        data.stream().collect(Collectors.groupingBy(m -> m.getName(), ))

//
//        data.stream().collect(Collectors.groupingBy(Measurement::getName))
//                .entrySet().stream() .flatMap(Stream::of)
//                .reduce(
//                        0, (i, value) -> { i+value.getValue()
//                        }, Integer::sum);

//        Map<String, Double> categotyPrise = data.stream().collect(Collectors.toMap(m -> m,
//                m -> new Measurement(m.getName(), m.getValue()),
//                (k, v) -> new Measurement(m.getValue() + v.amount, n.getValue() + v.price)));

//        Measurement measurement = data.stream()
//                .reduce((n, v) -> new Measurement(n.getName(), n.getValue() + v.getValue())).orElseThrow();
//
//        System.out.println("----"+map);
        return null; // todo
    }
}
