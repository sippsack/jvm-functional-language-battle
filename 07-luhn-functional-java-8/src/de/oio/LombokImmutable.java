package de.oio;

import java.util.Date;

import lombok.Getter;
import lombok.Value;

public class LombokImmutable {

	@Value
	private static class ImmutablePerson {
		String name;
		Date birthDay;
		
		@Getter(lazy = true)
		private final double[] cached = expensive();

		private double[] expensive() {
			double[] result = new double[1000000];
			for (int i = 0; i < result.length; i++) {
				result[i] = Math.asin(i);
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		Date birthDay = new Date();
		System.out.println(new ImmutablePerson("Duke", birthDay).getName());
		System.out.println(new ImmutablePerson("Duke", birthDay)
			.equals(new ImmutablePerson("Duke", birthDay)));
		System.out.println(new ImmutablePerson("Duke", birthDay) 
			== new ImmutablePerson("Duke", birthDay));
	}
}
