package me.kakaopaychallenge.controller.response;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.kakaopaychallenge.persistence.Membership;
import me.kakaopaychallenge.persistence.MembershipName;
import me.kakaopaychallenge.persistence.MembershipStatus;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MembershipResponse {

	private Long seq;

	private String membershipId;

	private String membershipName;

	private LocalDateTime startDate;

	private MembershipStatus membershipStatus;

	private Integer point;

	@Builder
	public MembershipResponse(Long seq, String membershipId, MembershipName membershipName, LocalDateTime startDate,
			MembershipStatus membershipStatus, Integer point) {
		this.seq = seq;
		this.membershipId = membershipId;
		this.membershipName = membershipName.getMembershipName();
		this.startDate = startDate;
		this.membershipStatus = membershipStatus;
		this.point = point;
	}

	public static MembershipResponse from (Membership membership) {
		return MembershipResponse.builder()
				.seq(membership.getSeq())
				.membershipId(membership.getMembershipId())
				.membershipName(membership.getMembershipName())
				.startDate(membership.getStartDate())
				.membershipStatus(membership.getMembershipStatus())
				.point(membership.getPoint())
				.build();
	}

}
