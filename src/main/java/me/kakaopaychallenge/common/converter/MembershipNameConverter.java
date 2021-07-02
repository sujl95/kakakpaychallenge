package me.kakaopaychallenge.common.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.util.ObjectUtils;

import me.kakaopaychallenge.persistence.MembershipName;

@Converter(autoApply = true)
public class MembershipNameConverter implements AttributeConverter<MembershipName, String> {

	@Override
	public String convertToDatabaseColumn(MembershipName membershipName) {
		if (ObjectUtils.isEmpty(membershipName)) {
			return null;
		}
		return membershipName.getMembershipName();
	}

	@Override
	public MembershipName convertToEntityAttribute(String code) {
		if (ObjectUtils.isEmpty(code)) {
			return null;
		}
		return Stream.of(MembershipName.values())
				.filter(membershipName -> membershipName.getMembershipName().equals(code))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
