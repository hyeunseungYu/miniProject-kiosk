package kirinman.miniproject_kiosk.repository;


import kirinman.miniproject_kiosk.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByPhoneNumber(String phoneNumber);


}
