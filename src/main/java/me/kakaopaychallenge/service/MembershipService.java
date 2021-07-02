package me.kakaopaychallenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kakaopaychallenge.controller.request.MembershipRequest;
import me.kakaopaychallenge.controller.response.MembershipResponse;
import me.kakaopaychallenge.persistence.Membership;
import me.kakaopaychallenge.repository.MembershipRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class MembershipService {

	private final MembershipRepository membershipRepository;

	@Transactional
	public Membership registerMembership(MembershipRequest.MembershipCreate membershipCreate) {
		Membership membership = membershipCreate.toEntity();
		membershipRepository.save(membership);
		log.info("멤버쉽 등록 id = {}", membership.getSeq());
		return membership;
	}

	@Transactional(readOnly = true)
	public List<MembershipResponse> getMemberships() {
		return	membershipRepository.findAll()
				.stream()
				.map(MembershipResponse::from)
				.collect(Collectors.toList());
	}

	@Transactional
	public void deleteMembership(String membershipId) {
		List<Membership> membership = membershipRepository.findByMembershipId(membershipId);
		if (ObjectUtils.isEmpty(membership)) {
			throw new RuntimeException("없다");
		}
		membership.forEach(Membership::changeMembershipStatus);

	}


	@Transactional(readOnly = true)
	public List<Membership> getMembershipId(String membershipId) {
		List<Membership> membership = membershipRepository.findByMembershipId(membershipId);
		if (ObjectUtils.isEmpty(membership)) {
			throw new RuntimeException("없다");
		}
		return membership;
	}
}
