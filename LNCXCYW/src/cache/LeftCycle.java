package cache;

public interface LeftCycle <T>{
	void init();
	void destory();
	void registe(Cache cache);
	void update(T t);
}
