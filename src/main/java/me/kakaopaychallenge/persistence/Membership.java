package me.kakaopaychallenge.persistence;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kakaopaychallenge.common.converter.MembershipNameConverter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "membership")
public class Membership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(nullable = false)
	private String membershipId;

	// @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	// @Convert(converter = MembershipNameConverter.class)
	private MembershipName membershipName;

	@Column(nullable = false)
	private LocalDateTime startDate;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 1)
	private MembershipStatus membershipStatus;

	@Column(nullable = false)
	private Integer point;

	@Builder
	public Membership(String membershipId, MembershipName membershipName, LocalDateTime startDate,
			MembershipStatus membershipStatus, Integer point) {
		this.membershipId = membershipId;
		this.membershipName = membershipName;
		this.startDate = startDate;
		this.membershipStatus = membershipStatus;
		this.point = point;
	}

	public void changeMembershipStatus() {
		membershipStatus = MembershipStatus.N;
	}

}
