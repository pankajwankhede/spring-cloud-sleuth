/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.sleuth.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.sleuth.Span;
import org.springframework.context.ApplicationListener;

/**
 * @author Spencer Gibb
 */
public class ArrayListSpanAccumulator implements ApplicationListener<SpanReleasedEvent> {
	private final List<Span> spans = new ArrayList<>();

	@Override
	public void onApplicationEvent(SpanReleasedEvent event) {
		this.spans.add(event.getSpan());
	}

	public List<Span> getSpans() {
		return this.spans;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ArrayListSpanAccumulator that = (ArrayListSpanAccumulator) o;
		return this.spans.equals(that.spans);
	}

	@Override
	public int hashCode() {
		return this.spans.hashCode();
	}

	@Override
	public String toString() {
		return "ArrayListSpanAccumulator{" +
				"spans=" + this.spans +
				'}';
	}
}
