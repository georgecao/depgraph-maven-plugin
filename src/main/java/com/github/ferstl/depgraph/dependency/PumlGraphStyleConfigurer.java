/*
 * Copyright (c) 2014 - 2017 the original author or authors.
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
package com.github.ferstl.depgraph.dependency;

import com.github.ferstl.depgraph.graph.GraphBuilder;
import com.github.ferstl.depgraph.graph.puml.PumlGraphFormatter;

public class PumlGraphStyleConfigurer implements GraphStyleConfigurer {

  private boolean showGroupId;
  private boolean showArtifactId;
  private boolean showTypes;
  private boolean showClassifiers;
  private boolean showVersionsOnNodes;
  private boolean showVersionOnEdges;

  @Override
  public GraphStyleConfigurer showGroupIds(boolean showGroupId) {
    this.showGroupId = showGroupId;
    return this;
  }

  @Override
  public GraphStyleConfigurer showArtifactIds(boolean showArtifactId) {
    this.showArtifactId = showArtifactId;
    return this;
  }

  @Override
  public GraphStyleConfigurer showTypes(boolean showTypes) {
    this.showTypes = showTypes;
    return this;
  }

  @Override
  public GraphStyleConfigurer showClassifiers(boolean showClassifiers) {
    this.showClassifiers = showClassifiers;
    return this;
  }

  @Override
  public GraphStyleConfigurer showVersionsOnNodes(boolean showVersionsOnNodes) {
    this.showVersionsOnNodes = showVersionsOnNodes;
    return this;
  }

  @Override
  public GraphStyleConfigurer showVersionsOnEdges(boolean showVersionOnEdges) {
    this.showVersionOnEdges = showVersionOnEdges;
    return this;
  }

  @Override
  public GraphBuilder<DependencyNode> configure(GraphBuilder<DependencyNode> graphBuilder) {
    return graphBuilder
        .useNodeNameRenderer(new PumlDependencyNodeNameRenderer(this.showGroupId,
            this.showArtifactId, this.showVersionsOnNodes))
        .useEdgeRenderer(new PumlDependencyEgdeRenderer())
        .graphFormatter(new PumlGraphFormatter());
  }

}
