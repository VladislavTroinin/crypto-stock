package ru.relex.cryptostock.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "balance_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "profile_id",
            insertable = false,
            updatable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "currency_id",
            insertable = false,
            updatable = false)
    private Currency currency;

    @Column(name = "amount")
    private BigDecimal amount;

}
