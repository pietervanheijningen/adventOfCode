<?php
require __DIR__ . "/input.php";

for ($j = 2; $j <= 20; $j++) {
    for ($i = 0; $i < count($input) - $j; $i++) {
        $numbers = [];
        for ($k = 0; $k < $j; $k++) {
            $numbers[] = $input[$i + $k];
        }
        if (array_sum($numbers) === 393911906) {
            sort($numbers);
            var_dump($numbers);
        }
    }
}


