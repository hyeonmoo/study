package org.greenart.kang;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.reflect.ClassPath;

@Component class Car{
	@Autowired Engine engine;
	@Resource Door door;
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", door=" + door + "]";
	}
}
class Truck extends Car{}
@Component class SportsCar extends Car{}
@Component class Engine{}
@Component class Door{}

public class Main {
	public static void main(String[] args) throws Exception{
		AppContext ac= new AppContext();
		Car car = (Car)ac.getBean("car");
		Engine engine = (Engine)ac.getBean("engine");
		Door door = (Door)ac.getBean("door");
				
		System.out.println("car="+car);
		System.out.println("engine="+engine);
		System.out.println("door="+door);
	}
}
class AppContext{
	Map<Object,Object> map;
	AppContext(){
		map = new HashMap<>();
		doComponentScan();
		doAutoWired();
		doResource();
	}
	private void doComponentScan() {
		try {
			ClassLoader cl = AppContext.class.getClassLoader();
			ClassPath cp = ClassPath.from(cl);
			Set<ClassPath.ClassInfo>set = cp.getTopLevelClasses("org.greenart.kang");
			
			for(ClassPath.ClassInfo ci:set) {
//				System.out.println("classInfo : "+ci);
				Class<?> clazz = ci.load();
				Component component = (Component)clazz.getAnnotation(Component.class);
				if(component != null) {
					String id = StringUtils.uncapitalize(ci.getSimpleName());
					map.put(id, clazz.newInstance());
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("map="+map);
	}
	
	private void doAutoWired() {
		try {
			for(Object bean : map.values()) {
				for(Field fd : bean.getClass().getDeclaredFields()) {
					if(fd.getAnnotation(Autowired.class)!=null) {
						fd.set(bean, getBean(fd.getType()));
						System.out.println("@AutoWired bean="+bean);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void doResource(){
		try {
			for(Object bean : map.values()) {
				for(Field fd : bean.getClass().getDeclaredFields()) {
					if(fd.getAnnotation(Resource.class)!=null) {
						fd.set(bean, getBean(fd.getName()));
						System.out.println("@Resource bean="+bean);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Object getBean(String key) {
		return map.get(key);
	}
	Object getBean(Class<?> clazz) {
		for(Object obj : map.values()) {
//			System.out.println("obj="+obj);
			if(clazz.isInstance(obj)) return obj;
		}
		return null;
	}
}

