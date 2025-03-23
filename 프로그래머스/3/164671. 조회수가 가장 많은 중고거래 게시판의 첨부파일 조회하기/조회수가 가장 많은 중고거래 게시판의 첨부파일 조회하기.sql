SELECT '/home/grep/src/'
    || BOARD_FILE.BOARD_ID
    || '/'
    || FILE_ID
    || FILE_NAME
    || FILE_EXT                         AS "FILE_PATH"
  FROM USED_GOODS_FILE  BOARD_FILE
  JOIN USED_GOODS_BOARD BOARD
    ON BOARD_FILE.BOARD_ID = BOARD.BOARD_ID
 WHERE VIEWS IN (
                  SELECT MAX(VIEWS)
                    FROM USED_GOODS_BOARD
                )
 ORDER BY FILE_PATH DESC