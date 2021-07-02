package me.kakaopaychallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.kakaopaychallenge.persistence.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
	void deleteByMembershipId(String membershipId);

	List<Membership> findByMembershipId(String membershipId);
}
