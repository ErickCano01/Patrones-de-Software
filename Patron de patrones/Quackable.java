
public interface Quackable extends QuackObservable  {

    public void quack();

    @Override
    public void registerObserver(Observer observer);

    @Override
    public void notifyObservers();

}
