package pl.mikolaj.r2025.rentea.lambdas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

interface OrderRepo {
	Stream<Order> findByActiveTrue();	//1 mln orders
}

class FileExporter {
	public File exportFile(String fileName, Consumer<Writer> contentWriter) {
		File file = new File ("export/" + fileName);
		try (Writer writer = new FileWriter(fileName)) {
			contentWriter.accept(writer);
			return file;
		} catch (IOException e) {
			//e.printStackTrace();
		}

		return file;
	}
}

class Client {
	public static void main(String[] args) {
		FileExporter fileExporter = new FileExporter();
		OrderExportWriter writer = new OrderExportWriter();
		fileExporter.exportFile("orders.csv", Unchecked.consumer(writer::writeContent));
	}
}

class OrderExportWriter {
	private OrderRepo repo;

	public void writeContent(Writer writer) throws IOException {
		writer.write("OrderID;Date\n");
		repo.findByActiveTrue()
				.map(order -> order.getId() + ";" + order.getCreationDate())
				.forEach(Unchecked.consumer(writer::write));
	}
}


class Order {
	private Long id;
	private Date creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}

@FunctionalInterface
interface CheckedConsumer<T, E extends Exception> {
	void accept(T t) throws E;
}

@FunctionalInterface
interface CheckedFunction<T, R, E extends Exception> {
	R apply(T t) throws E;
}

class Unchecked {
	public static <T, E extends Exception> Consumer<T> consumer(CheckedConsumer<T, E> checkedConsumer) {
		return t -> {
			try {
				checkedConsumer.accept(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	public static <T, R, E extends Exception> Function<T, R> function(CheckedFunction<T, R, E> checkedFunction) {
		return t -> {
			try {
				return checkedFunction.apply(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};

	}
}
