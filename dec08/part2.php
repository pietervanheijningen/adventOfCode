<?php
require __DIR__ . "/input.php";

function runWithChangedInstruction($index, $toWhat) {
    global $input;
    $instructionIdsRan = [];
    $acc = 0;
    $i = 0;
    while (count($instructionIdsRan) < 100000) {
        if (count($input) <= $i) {
            var_dump($acc);
            die();
        }
        $parts = explode(" ", $input[$i]);
        if ($i == $index) {
            $instruction = $toWhat;
        } else {
            $instruction = $parts[0];
        }
        $value = $parts[1];

        $instructionIdsRan[] = $i;
        if ($instruction == 'nop') {
            $i++;
        } elseif ($instruction == 'acc') {
            $acc += $value;
            $i++;
        } elseif ($instruction == 'jmp') {
            $i += $value;
        }
    }
}

$i = 0;
foreach ($input as $loc) {
    $instruction = explode(" ", $input[$i])[0];
    if ($instruction == 'nop') {
        runWithChangedInstruction($i, 'jmp');
    } elseif ($instruction == 'jmp') {
        runWithChangedInstruction($i, 'nop');
    }

    $i++;
}
