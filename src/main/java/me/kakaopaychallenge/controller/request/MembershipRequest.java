package me.kakaopaychallenge.controller.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import me.kakaopaychallenge.persistence.Membership;
import me.kakaopaychallenge.persistence.MembershipName;
import me.kakaopaychallenge.persistence.MembershipStatus;

public class MembershipRequest {

	@Getter
	@Setter
	public static class MembershipCreate {

		@NotBlank
		private String membershipId;

		@NotNull
		private MembershipName membershipName;

		@NotNull
		private Integer point;

		public Membership toEntity() {
			return Membership.builder()
					.membershipId(membershipId)
					.membershipName(membershipName)
					.startDate(LocalDateTime.now())
					.membershipStatus(MembershipStatus.Y)
					.point(point)
					.build();
		}
	}

}
