package uy.edu.um.prog2.adt.Queue;

import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

public class Queue<G> implements MyPiorityQueue<G> {
	private Nodo<G> first;
//	private Nodo<G> last;
	
	@Override
	public void enqueue(G element) {
		Nodo<G> oFirst = new Nodo<G>(element);
		if(first == null) {
			first = oFirst;
//			last = oFirst;
			first.setNext(null);
			first.setBefore(null);
//			last.setBefore(first);
		}else {
			Nodo<G> oTemp = last();
			oTemp.setNext(oFirst);
			oFirst.setBefore(oTemp);
		}
	}

	@Override
	public G dequeue() throws EmptyQueueException {
		if (first == null) {
			EmptyQueueException e = new EmptyQueueException("La cola esta vacia.");
			throw e;
		}
		Nodo<G> oTemp = first;
		G oExit = oTemp.getValue();
		if(oTemp.getNext()==null) {
			first=null;
		}else {
			first = oTemp.getNext();
			oTemp.getNext().setBefore(null);
			oTemp.setNext(null);
			
		}
		
//		if (oTemp == first) {
//			oExit = oTemp.getValue();
//			first = null;
//		} else {
//			oTemp.getBefore().setNext(null);
//			last().setBefore(null);
//			oExit = oTemp.getValue();
//		}
		return oExit;
	}

	@Override
	public boolean isEmpty() {
		boolean bE = false;
		if(first == null)
			bE = true;
		return bE;
	}

	@Override
	public G getFirst() throws EmptyQueueException {
		if (first == null)
			throw new EmptyQueueException("La cola esta vacia.");
		return first.getValue();
	}

	@Override
	public void insert(G element, int pioridad) {
		Nodo<G> oInsert = new Nodo<>(element, pioridad);
		Nodo<G> oFirst = first;
		boolean bR = true;
		if (first == null) {
			first = oInsert;
//			last = oInsert;
		} else {
			while ( bR && oFirst.getPiority() >= pioridad ) {
				oFirst = oFirst.getNext();
				if (oFirst == null)
					bR = false;
			}
			if (!bR) {
				Nodo<G> oTemp = last();
				oInsert.setBefore(oTemp);
				oTemp.setNext(oInsert);
//				last = oInsert;
			} else {
				if (oFirst.getBefore() != null) {
					oFirst.getBefore().setNext(oInsert);
					oInsert.setBefore(oFirst.getBefore());
					oFirst.setBefore(oInsert);
					oInsert.setNext(oFirst);
				} else {
					Nodo<G> oTemp = first;
					oInsert.setNext(oTemp);
					oTemp.setBefore(oInsert);
					first = oInsert;
				}
			}

		}

	}
	private Nodo<G> last(){
		Nodo<G> oTemp = first;
		while(oTemp.getNext()!=null) {
			oTemp=oTemp.getNext();
		}
		return oTemp;
	}
}
