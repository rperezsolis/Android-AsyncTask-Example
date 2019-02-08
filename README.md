# Android-AsyncTask-Example
Simple android app that shows how to implement a task in a background thread to avoid to block the UI when an asynchronous operation is running.

To explain the asynchronous operation that is running in the background imagine the next:
- You have a matrix of m rows and n columns, and you are standing at the position [0,0].
- Then, you start to walk through the first row at rigth direction, crossing all the columns.
- When you get to the final column, you turn to the rigth and keep walking through the last column at down direction, crossing all the restant rows.
- So, you are going to walk in a spiral way getting closer to the center of the matrix.

With that said, the operation in background is an algorithm to determine on what direction you were walking when you get at the final cell.
This may look very trivial when the matrix is small, i.e. 3 rows per 5 columns. But, if the matrix has 1x10^9 rows and 1x10^9 columns, the processing time can get very large.

If we make that long process on the main thread (the UI thread), the UI will get block, the user won't be able to interact whit it, and the system will kill our app.
To avoid all that unfourtunate events, we must run the process inside a background thread, and for that, we use AsyncTask class.
