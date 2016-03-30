package cache;

public interface LeftCycle <T>{
	void init();
	void destory();
	void add(T newt);
	void delete(T oldT);
	void register(Listener listener);
}
