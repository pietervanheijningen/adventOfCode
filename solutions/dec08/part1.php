<?php
require __DIR__ . "/input.php";

$instructionIdsRan = [];
$acc = 0;
$i = 0;
while (true) {
    $parts = explode(" ", $input[$i]);
    $instruction = $parts[0];
    $value = $parts[1];

    if (in_array($i, $instructionIdsRan)) {
        var_dump($acc);
        die();
    } else {
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

