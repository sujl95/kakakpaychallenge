package me.kakaopaychallenge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.kakaopaychallenge.controller.request.MembershipRequest;
import me.kakaopaychallenge.controller.response.ApiResult;
import me.kakaopaychallenge.controller.response.MembershipResponse;
import me.kakaopaychallenge.persistence.Membership;
import me.kakaopaychallenge.service.MembershipService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/membership")
public class MembershipController {

	private final MembershipService membershipService;

	@GetMapping
	public ApiResult getMemberships() {
		List<MembershipResponse> memberships = membershipService.getMemberships();
		return ApiResult.builder()
				.success(true)
				.response(memberships)
				.build();
	}

	@PostMapping
	public ApiResult createMembership(@Valid @RequestBody MembershipRequest.MembershipCreate membershipCreate) {
		MembershipResponse membership = MembershipResponse.from(membershipService.registerMembership(membershipCreate));
		return ApiResult.builder()
				.success(true)
				.response(membership)
				.build();
	}

	@PatchMapping("/{membershipId}")
	public ApiResult deleteMembership(@PathVariable String membershipId) {
		membershipService.deleteMembership(membershipId);

		return ApiResult.builder()
				.success(true)
				.response(true)
				.build();
	}

	@GetMapping("{membershipId}")
	public ApiResult getMembershipId(@PathVariable String membershipId) {
		List<Membership> membership = membershipService.getMembershipId(membershipId);

		return ApiResult.builder()
				.success(true)
				.response(membership)
				.build();
	}


}
