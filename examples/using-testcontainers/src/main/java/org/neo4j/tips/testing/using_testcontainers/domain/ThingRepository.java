/*
 * Copyright (c) 2019 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.tips.testing.using_testcontainers.domain;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author Michael J. Simons
 */
// tag::thing-repository[]
public interface ThingRepository extends Neo4jRepository<Thing, Long> {

	List<Thing> findThingByNameMatchesRegex(String regexForName);

	@Query(value
		= " MATCH (t:Thing) WHERE t.name = $name"
		+ " RETURN t.name AS name, examples.getGeometry(t) AS wkt")
	ThingWithGeometry findThingWithGeometry(String name);
}
// end::thing-repository[]
