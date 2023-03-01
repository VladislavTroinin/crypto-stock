package ru.relex.cryptostock.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "operation_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "balance_id",
            insertable = false,
            updatable = false)
    private Balance balance;

    @Column(name = "implement_time")
    private LocalDateTime dateTime;

    @Column(name = "amount_delta")
    private BigDecimal amount_delta;

}
