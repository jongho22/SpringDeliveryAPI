package org.delivery.db.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

@SuperBuilder // 부모가 가지고 있는 변수도 지정할 수 있는 Builder
@Data
@EqualsAndHashCode(callSuper = true) // 객체 비교 => true : 부모에 있는 값까지 포함해서 비교
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

}
