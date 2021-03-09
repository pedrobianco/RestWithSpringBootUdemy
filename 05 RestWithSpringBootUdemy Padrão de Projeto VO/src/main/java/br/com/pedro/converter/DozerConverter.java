package br.com.pedro.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {
	
	private static Mapper maper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D > D parseObject(O origin, Class<D> destination) {
		return maper.map(origin, destination);
	}
	
	public static <O, D > List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		for (Object o : origin) {
			destinationObjects.add(maper.map(o,  destination));
		}
		return destinationObjects;
	}

}
