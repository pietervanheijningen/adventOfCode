<?php

require 'input.php';
$layout = $input;

function getNumberOfOccupiedAdjacentSeats($lineNr, $seatNr)
{
    global $originalLayout;
    $occupiedNr = 0;

    // search to the right
    for($i = $seatNr+1; $i < strlen($originalLayout[0]); $i++) {
        switch ($originalLayout[$lineNr][$i]) {
            case "#":
                $occupiedNr++;
                break 2;
            case ".":
                break;
            case "L":
                break 2;
        }
    }

    // search to the left
    for($i = $seatNr-1; $i > -1; $i--) {
        switch ($originalLayout[$lineNr][$i]) {
            case "#":
                $occupiedNr++;
                break 2;
            case ".":
                break;
            case "L":
                break 2;
        }
    }

    // search to the bottom
    for($i = $lineNr+1; $i < count($originalLayout); $i++) {
        switch ($originalLayout[$i][$seatNr]) {
            case "#":
                $occupiedNr++;
                break 2;
            case ".":
                break;
            case "L":
                break 2;
        }
    }


    // search to the top
    for($i = $lineNr-1; $i > -1; $i--) {
        switch ($originalLayout[$i][$seatNr]) {
            case "#":
                $occupiedNr++;
                break 2;
            case ".":
                break;
            case "L":
                break 2;
        }
    }

    // search to the top right
    for($i = 1; $i < min($lineNr+1, strlen($originalLayout[0])); $i++) {
        switch ($originalLayout[$lineNr-$i][$seatNr+$i]) {
            case "#":
                $occupiedNr++;
                break 2;
            case ".":
                break;
            case "L":
                break 2;
        }
    }

    // search to the bottom right
    for($i = 1; $i < min(count($originalLayout)-$lineNr, strlen($originalLayout[0])-$seatNr); $i++) {
        switch ($originalLayout[$lineNr+$i][$seatNr+$i]) {
            case "#":
                $occupiedNr++;
                break 2;
            case ".":
                break;
            case "L":
                break 2;
        }
    }

    // search to the bottom left
    for($i = 0; $i < min(count($originalLayout), $seatNr); $i++) {
        switch ($originalLayout[$lineNr+($i+1)][$seatNr-($i+1)]) {
            case "#":
                $occupiedNr++;
                break 2;
            case ".":
                break;
            case "L":
                break 2;
        }
    }

    // search to the top left
    for($i = 0; $i < min($lineNr, $seatNr); $i++) {
        switch ($originalLayout[$lineNr-($i+1)][$seatNr-($i+1)]) {
            case "#":
                $occupiedNr++;
                break 2;
            case ".":
                break;
            case "L":
                break 2;
        }
    }

    return $occupiedNr;
}

$layout = str_replace('L', '#', $layout);

foreach (range(1,100) as $temp) {
    $originalLayout = $layout;

    for ($line = 0; $line < count($originalLayout); $line++) {
        for ($seat = 0; $seat < strlen($originalLayout[0]); $seat++) {
            if ($originalLayout[$line][$seat] == 'L') {
                if (getNumberOfOccupiedAdjacentSeats($line, $seat) == 0) {
                    $layout[$line][$seat] = '#';
                }
            } elseif ($originalLayout[$line][$seat] == '#') {
                if (getNumberOfOccupiedAdjacentSeats($line, $seat) >= 5) {
                    $layout[$line][$seat] = 'L';
                }
            }
        }
    }
}

// print layout
$occupiedCount = 0;
for ($line = 0; $line < count($layout); $line++) {
    for ($seat = 0; $seat < strlen($layout[0]); $seat++) {
        echo $layout[$line][$seat];
        if ($layout[$line][$seat] == '#') $occupiedCount++;
    }
    echo "\n";
}

var_dump($occupiedCount);