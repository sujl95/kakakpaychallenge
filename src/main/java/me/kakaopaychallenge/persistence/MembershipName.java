package me.kakaopaychallenge.persistence;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MembershipName {
	HAPPYPOINT("happypoint"),
	SHINSEGAE("shinsegae"),
	CJONE("cjone");

	private final String membershipName;

	@JsonCreator
	public static MembershipName from(String s) {
		return MembershipName.valueOf(s.toUpperCase());
	}

}
