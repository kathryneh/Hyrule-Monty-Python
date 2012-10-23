public interface Incrementer {
   public void increment();
   public void incremented();
   public void register(
    Incrementer incrementer);
}
