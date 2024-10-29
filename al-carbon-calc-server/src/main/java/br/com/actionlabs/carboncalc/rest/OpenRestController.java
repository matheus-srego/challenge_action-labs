package br.com.actionlabs.carboncalc.rest;

import br.com.actionlabs.carboncalc.dto.*;
import br.com.actionlabs.carboncalc.service.CarbonCalculationProcessManager;
import br.com.actionlabs.carboncalc.service.UserEmissionFactorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/open")
@RequiredArgsConstructor
@Slf4j
public class OpenRestController {

  private final CarbonCalculationProcessManager processManager;

  private final UserEmissionFactorService userEmissionFactorService;

  @PostMapping("start-calc")
  public ResponseEntity<StartCalcResponseDTO> startCalculation(
      @Valid @RequestBody StartCalcRequestDTO request) {
    return ResponseEntity.ok(this.userEmissionFactorService.create(request));
  }

  @PutMapping("info")
  public ResponseEntity<UpdateCalcInfoResponseDTO> updateInfo(
      @RequestBody UpdateCalcInfoRequestDTO request) {
    return ResponseEntity.ok(this.processManager.saveCarbonInfo(request));
  }

  @GetMapping("result/{id}")
  public ResponseEntity<CarbonCalculationResultDTO> getResult(@PathVariable String id) {
    return ResponseEntity.ok(this.processManager.calculateTotalFootPrint(id));
  }

}
