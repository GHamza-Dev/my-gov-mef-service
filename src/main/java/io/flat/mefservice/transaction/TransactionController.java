package io.flat.mefservice.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mef/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(
          transactionService.getAllTransactions()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                transactionService.getTransactionById(id)
        );
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TransactionDto transactionDto){
        if(transactionService.createTransaction(transactionDto)){
            return ResponseEntity.ok("Transaction created successfully!");
        }

        return ResponseEntity.status(500).body("Ops something went wrong!");
    }
}
