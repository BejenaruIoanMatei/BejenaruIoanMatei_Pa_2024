import java.util.Objects;

public class Pair<T, U> {
        private T first;
        private U second;
        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

     public T getFirst() {
         return first;
     }

     public void setFirst(T first) {
         this.first = first;
     }

     public U getSecond() {
         return second;
     }

     public void setSecond(U second) {
         this.second = second;
     }

     @Override
     public String toString()
     {
         return ("pereche "+ first+ " and " +second);
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }
}

