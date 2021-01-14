package aoc2019.dec03;

import java.util.Objects;

public class Tuple<Fst, Snd> {
    public Fst fst;
    public Snd snd;

    public Tuple(Fst fst, Snd snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return Objects.equals(fst, tuple.fst) &&
                Objects.equals(snd, tuple.snd);
    }

    @Override
    public String toString() {
        return "tuples.add(new Tuple<>(" + fst + ", " + snd + "))";
    }
}
