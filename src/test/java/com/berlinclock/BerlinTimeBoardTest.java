package com.berlinclock;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.berlinclock.BerlinTimeBoard;
import com.berlinclock.domain.LampsRow;
import com.berlinclock.domain.TimeHolder;

/**
 * Berlin Clock board test class
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BerlinTimeBoardTest extends BaseBerlinClockTest {

	
	private BerlinTimeBoard berlinTimeBoard;
	@Mock private LampsRow lampsRow;
	
	/**
	 * Ensure that rows are added correctly to the board
	 */
	@Test
	public void testBerlinTimeBoard_add_correct_number_of_rows() throws Exception {
		
		when(lampsRow.getLampsRow(any(TimeHolder.class))).thenReturn("X");
		
		berlinTimeBoard = new BerlinTimeBoard(getTime("00:00:00"));
		berlinTimeBoard.addLampsRow(lampsRow);
		berlinTimeBoard.addLampsRow(lampsRow);
		berlinTimeBoard.addLampsRow(lampsRow);
		
		assertThat(getNumberOfRowsInString(berlinTimeBoard.showTime()), is(3));
	}
	
	/**
	 * Ensure that board is empty is no rows were added
	 */
	@Test
	public void testBerlinTimeBoard_show_empty_board_if_no_rows_added() throws Exception {
		
		berlinTimeBoard = new BerlinTimeBoard(getTime("00:00:00"));
		
		String board = berlinTimeBoard.showTime();
		
		assertThat(board, is(""));
	}
	
}
